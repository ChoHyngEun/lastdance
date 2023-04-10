package com.rainbowsweet.lastdance.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table
@DynamicUpdate
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "사용자 아이디는 필수 입니다.")
    private String memberId;
    /*
    * nullable 속성은 해당 필드가 null 값을 허용하는지 여부를 설정하는데 사용
    * unique = true는 해당 필드의 값이 데이터베이스 테이블에서 유일한 값이여야하는것으로 매핑되도록 함
    * memberid는 추후 id로 사용할 예정
    *
    * */

    @Column(nullable = false)
    @NotBlank(message = "사용자 이름은 필수 입력 항목입니다.")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이여야 합니다.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "비밀번호는 알파벳 대소문자와 숫자,특수문자(@$!%*?&)중 하나를 포함한 8자리 이상이어야 합니다.")
    private String password;

    @Column(nullable = false)
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    private boolean login;

    private int logincount;
    /*
    * boolean login에서 true or false로 값이 매겨지고
    * true가 될때마다 logincount에 1씩 쌓이도록 할예정
    * */



    @Column(nullable = false)
    private String otpcheck;


    public Member(){

    }
    public Member(String memberId, String name, String password, String email){
        this.memberId = memberId;
        this.name = name;
        this.password = password;
        this.email = email;

    }

    public Long getId(){return id;}
    /*
    * getid()라는 이름을 가진 메서드를 만드는것.
    * 메서드란 클래스 안에서 기능을 수행하는 코드들의 모음.
    * 이 메서드는 'Long'이란 종류의 값을 반환하는 메서드.
    * 이메서드는 객체 내부의 'id'라는 변수의 값을 반환함.
    * 쉽게 말하면 책이 한권 있는데 그 책에는 제목, 저자, 출판사 등의 여러정보가 있음.
    * 그 정보안에서 ID라는 정보가 있을 수 있다. 이 메서드는 그 책의 ID값을 가져오는 메서드다.
    * 이 메서드를 호출하면 이 책의 ID값을 알아 낼 수 있음.
    * */

    public void setId(Long id) {
        this.id = id;
    }
    /*
    * setId 메서드는 private으로 선언된 id 정보를 수정하기 위해 사용하는 메서드입니다.
    * getId는 private으로 선언된 id 정보를 가져오기 위한 메서드이고
    * setId는 정보를 수정하기 위해 사용하는 메서드, 이렇게 사용하면 클래스 내부의 정보를 안전하게 관리할 수 있습니다.
    * */

    public String getName() { return name;}

    public void setName(String name) {
        this.name = name;
    }


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtpcheck() {
        return otpcheck;
    }

    public void setOtpcheck(String otpcheck) {
        this.otpcheck = otpcheck;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public int getLogincount() {
        return logincount;
    }

    public void setLogincount(int logincount) {
        this.logincount = logincount;
    }
/*public changePassword(String newPassword){
        this.password = newPassword;
    }*/
}
