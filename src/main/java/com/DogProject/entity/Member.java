package com.DogProject.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("회원 고유 ID")
    private int mIdx;

    @Column(nullable = false, length = 50)
    @Comment("회원 이름")
    private String name;

    @Column(nullable = false, length = 10)
    @Comment("회원 생년월일 (yyyy-MM-dd)")
    private String birthday;

    @Column(length = 10)
    @Comment("회원 성별 (예: 남성/여성)")
    private String gender;

    @Column(length = 255)
    @Comment("회원 주소")
    private String address;

    @Column(length = 20)
    @Comment("회원 등급 (예: 일반, 관리자)")
    private String grade;

    @Column(length = 10)
    @Comment("회원 가입 타입 (예: 카카오, 네이버, 구글, 사이트)")
    private String mType;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    @Comment("회원 포인트 (적립금)")
    private int point;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Comment("회원이 등록한 강아지 리스트")
    private List<Dog> dogs;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Comment("회원의 게시글 리스트")
    private List<Board> boards;

    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Comment("회원이 보낸 채팅 리스트")
    private List<Chat> sentChats;

    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Comment("회원이 받은 채팅 리스트")
    private List<Chat> receivedChats;
}
