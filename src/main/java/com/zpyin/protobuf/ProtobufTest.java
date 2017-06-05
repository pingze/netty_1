package com.zpyin.protobuf;

/**
 * Created by zpyin on 2017/6/4.
 */
public class ProtobufTest {

    public static void main(String[] args) throws Exception {

        DataInfo.Student student = DataInfo.Student.newBuilder()
                                        .setName("zhangsan")
                                        .setAge(20)
                                        .setAddress("shanghai")
                                        .build();
        byte[] bytes = student.toByteArray();
        DataInfo.Student student2 = DataInfo.Student.parseFrom(bytes);
        System.out.println(student2.getName() + ":" + student2.getAge() + ":" + student2.getAddress());
    }
}
