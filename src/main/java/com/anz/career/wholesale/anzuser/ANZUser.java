package com.anz.career.wholesale.anzuser;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ANZUser implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  private String id;

}
