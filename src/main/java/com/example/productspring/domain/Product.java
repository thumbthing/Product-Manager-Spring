package com.example.productspring.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
// Entity 가 붙어 있으면 JPA 가 관리를 한다는 뜻이다
// 221226 오류 정리를 좀 해보자
//@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PK = id
    public Long no;
    public String name;
    public int price;
    public int stock;
}