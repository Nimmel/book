package com.readbooker.website.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id // 主键
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
  private long id;

  @NotEmpty(message = "姓名不能为空")
  @Size(min=2, max=20)
  @Column(nullable = false, length = 20) // 映射为字段，值不能为空
  private String username;

  @NotEmpty(message = "密码不能为空")
  @Size(min=1, max=30)
  @Column(nullable = false, length = 20) // 映射为字段，值不能为空
  private String passWord;

  @Size
  @Column(nullable = false)
  private String sex;

  @NotEmpty(message = "邮箱不能为空")
  @Size(max=50)
  @Email(message= "邮箱格式不对" )
  @Column(nullable = false, length = 50, unique = true)
  private String email;

  private String avatar;

}
