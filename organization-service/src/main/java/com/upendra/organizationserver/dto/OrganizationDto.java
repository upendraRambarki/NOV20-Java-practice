package com.upendra.organizationserver.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {

	
	Long id;
	String organizationName;
	String organizationDescription;
	String organizationCode;
	LocalDateTime createdDate;
}
