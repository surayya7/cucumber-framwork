package apiTests;

import api.BoraApI;
import pojo.Post;

public class LoginTest {

	public static void main(String[] args) {
		String token = BoraApI.login( "surayya117@gmail.com", "emsb92921S");
		Post post = BoraApI.createPost(token, "Surayya Test Post from RestAssured  - 1");
		
		System.out.println(post.text);
		System.out.println(post.name);
		System.out.println(post.date);

	}

}
