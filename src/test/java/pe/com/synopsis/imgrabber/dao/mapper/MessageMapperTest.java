package pe.com.synopsis.imgrabber.dao.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MessageMapperTest {
	
	@Before
	public void init() {
	}
	
	@Test
	public void whenRegexImg() {
		String pathCdn = "https://localhost:8443/ig-web-service/resource/v1/img";
		String msgText = "<span class=\"_2ZDCk\"><img crossorigin=\"anonymous\" src=\"/img/4742377b4ae743abd4f117e58c6c829b_w_e1905-40.png\" alt=\"??\" draggable=\"false\" class=\"_298rb _2a0VK selectable-text invisible-space copyable-text\" data-plain-text=\"??\" style=\"visibility: visible;\"></span><span class=\"_2ZDCk\"><img crossorigin=\"anonymous\" src=\"/img/4742377b4ae743abd4f117e58c6c829b_w_e1905-40.png\" alt=\"??\" draggable=\"false\" class=\"_298rb _2a0VK selectable-text invisible-space copyable-text\" data-plain-text=\"??\" style=\"visibility: visible;\"></span><span class=\"_2ZDCk\"><img crossorigin=\"anonymous\" src=\"https://localhost:8443/ig-web-service/resource/v1/img/4742377b4ae743abd4f117e58c6c829b_w_e1905-40.png?[TOKEN]\" alt=\"??\" draggable=\"false\" class=\"_298rb _2a0VK selectable-text invisible-space copyable-text\" data-plain-text=\"??\" style=\"visibility: visible;\"></span>";
		String result = msgText.replaceAll("(src=\\\")\\/img\\/([\\w\\d_-]*.png)\"", "$1".concat(pathCdn).concat("$2?[TOKEN]\"") );
		Assert.assertEquals( "<span class=\"_2ZDCk\"><img crossorigin=\"anonymous\" src=\"https://localhost:8443/ig-web-service/resource/v1/img4742377b4ae743abd4f117e58c6c829b_w_e1905-40.png?[TOKEN]\" alt=\"??\" draggable=\"false\" class=\"_298rb _2a0VK selectable-text invisible-space copyable-text\" data-plain-text=\"??\" style=\"visibility: visible;\"></span><span class=\"_2ZDCk\"><img crossorigin=\"anonymous\" src=\"https://localhost:8443/ig-web-service/resource/v1/img4742377b4ae743abd4f117e58c6c829b_w_e1905-40.png?[TOKEN]\" alt=\"??\" draggable=\"false\" class=\"_298rb _2a0VK selectable-text invisible-space copyable-text\" data-plain-text=\"??\" style=\"visibility: visible;\"></span><span class=\"_2ZDCk\"><img crossorigin=\"anonymous\" src=\"https://localhost:8443/ig-web-service/resource/v1/img/4742377b4ae743abd4f117e58c6c829b_w_e1905-40.png?[TOKEN]\" alt=\"??\" draggable=\"false\" class=\"_298rb _2a0VK selectable-text invisible-space copyable-text\" data-plain-text=\"??\" style=\"visibility: visible;\"></span>", result);
	}
	
}
