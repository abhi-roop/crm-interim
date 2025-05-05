package com.cts.crm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@NotBlank(message = "Name cannot be empty")
	@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	private String name;

	@NotBlank(message = "Contact information is required")
	@Email(message = "Invalid email format")
	private String contactInfo;

	@NotBlank(message = "Purchase history must not be empty")
	private String purchaseHistory;

	@NotBlank(message = "Segmentation data is required")
	private String segmentationData;
}
