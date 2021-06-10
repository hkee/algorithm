package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

class Member {
    int age;
    String name;
    int no;
    Member(int age,String name,int no) {
        this.age=age;
        this.name = name;
        this.no = no;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public int getNo() {
        return no;
    }
}

public class MemberSort {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Member> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            String temp[] = br.readLine().split(" ");
            list.add(new Member(Integer.parseInt(temp[0]),temp[1],i));
        }
        list.sort(Comparator.comparing(Member::getAge).thenComparing(Member::getNo));

        for(Member m : list) {
            System.out.println(m.age+ " "+m.name);
        }

    }
}
