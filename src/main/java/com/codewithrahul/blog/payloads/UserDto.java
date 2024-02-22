package com.codewithrahul.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// this class is exactly same(just made to make things easier) as user but while the project goes on then based upon
// the useCase we may need less variables of the user or may be we have to add more
// fields to the User, then in such a case rather making the changes to User entity
// we will make changes here and our User class will be as it is
// and we will expose this class only to the APIs directly without exposing User


@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
	
	
	

}
