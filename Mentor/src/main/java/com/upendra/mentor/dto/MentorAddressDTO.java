package com.upendra.mentor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentorAddressDTO {
	
	private MentorDto mentor;
	private AddressDto address;
}
