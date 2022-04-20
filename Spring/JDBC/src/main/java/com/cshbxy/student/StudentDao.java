package com.cshbxy.student;

import java.util.List;

public interface StudentDao {
    //���ѧ����Ϣ
    public int addStudent(Student student);

    //ɾ��ѧ����Ϣ
    public int deleteStudent(int id);

    //�޸�ѧ����Ϣ
    public int updateStudent(Student student);

    //��ѯ����ѧ����Ϣ
    public Student findStudentById(int id);

    //��ѯ����ѧ����Ϣ
    public List<Student> findAllStudent();
}
