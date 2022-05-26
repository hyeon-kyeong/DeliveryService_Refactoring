package com.ssd.delivery.controller.account;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.service.DeliveryFacade;
import com.ssd.delivery.service.Message;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/delivery/signon.do")
public class SignonController {

	private DeliveryFacade delivery;
	private static String RSA_WEB_KEY = "_RSA_WEB_Key_"; // 개인키 session key
	private static String RSA_INSTANCE = "RSA"; // rsa transformation
	
	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}

	@GetMapping
	public String showForm(@ModelAttribute("accountDTO") AccountDTO accountDTO, 
			RedirectAttributes redirectAttributes,
			HttpServletRequest request, ModelMap model) throws Exception {
		
		initRsa(request);

		return  "login";
	}

	public void initRsa(HttpServletRequest request) {
		HttpSession session = request.getSession();
		 
		KeyPairGenerator generator;
		try {
		    generator = KeyPairGenerator.getInstance(RSA_INSTANCE);
		    generator.initialize(1024);
		 
		    KeyPair keyPair = generator.genKeyPair();
		    KeyFactory keyFactory = KeyFactory.getInstance(RSA_INSTANCE);
		    PublicKey publicKey = keyPair.getPublic();
		    PrivateKey privateKey = keyPair.getPrivate();
		 
		    session.setAttribute(RSA_WEB_KEY, privateKey); // session에 RSA 개인키를 세션에 저장
		 
		    RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
		    String publicKeyModulus = publicSpec.getModulus().toString(16);
		    String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
		 
		    request.setAttribute("RSAModulus", publicKeyModulus); // rsa modulus 를 request 에 추가
		    request.setAttribute("RSAExponent", publicKeyExponent); // rsa exponent 를 request 에 추가
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	@PostMapping
	public String handleRequest(HttpServletRequest request,
			HttpSession session,
			@RequestParam("USERNAME") String username,
			@RequestParam("PASSWORD") String password, 
			@RequestParam(value = "forwardAction", required = false) String forwardAction,
			Model model) throws Exception {

		PrivateKey privateKey = (PrivateKey) session
				.getAttribute(RSA_WEB_KEY);

		// 복호화
		username = decryptRsa(privateKey, username);
		password = decryptRsa(privateKey, password);

		// 개인키 삭제
		session.removeAttribute(RSA_WEB_KEY);
		
		AccountDTO account = delivery.findUser(username);

		if (account == null || !account.getPassword().equals(password)) { // 로그인 정보 불일치
			model.addAttribute("data",
					new Message("가입되지 않은 아이디거나 잘못된 비밀번호 입니다.", "/"));
			initRsa(request);
			return "login";
		}

		model.addAttribute("userSession", account);

		if (forwardAction != null) {
			return "redirect:/" + forwardAction;
		} else {
			return "redirect:/";
		}
	}

	//복호화
	private String decryptRsa(PrivateKey privateKey, String securedValue) throws Exception {
	    Cipher cipher = Cipher.getInstance(RSA_INSTANCE);
	    byte[] encryptedBytes = hexToByteArray(securedValue);
	    cipher.init(Cipher.DECRYPT_MODE, privateKey);
	    System.out.println(privateKey);
	    byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
	    String decryptedValue = new String(decryptedBytes, "utf-8"); // 문자 인코딩 주의.
	    return decryptedValue;
	}
	 
	 
	//16진 문자열을 BYTE 배열로 변환
	public static byte[] hexToByteArray(String hex) {
	    if (hex == null || hex.length() % 2 != 0) { return new byte[] {}; }
	 
	    byte[] bytes = new byte[hex.length() / 2];
	    for (int i = 0; i < hex.length(); i += 2) {
	        byte value = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
	        bytes[(int) Math.floor(i / 2)] = value;
	    }
	    return bytes;
	}

}
