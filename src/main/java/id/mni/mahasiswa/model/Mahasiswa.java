package id.mni.mahasiswa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_mahasiswa")
@Data
public class Mahasiswa {

    @Id
    @SequenceGenerator(name = "USER_SEQ",sequenceName = "user_seq",
            initialValue = 5, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    private Integer id;

    @Column(name = "nim", columnDefinition = "varchar(25)")
    private String nim;

    @Column(name ="first_name", columnDefinition = "varchar(100)")
    private String firstName;

    @Column(name ="last_name", columnDefinition = "varchar(100)")
    private String lastName;

    @Column(name ="email_name", columnDefinition = "varchar(100)")
    private String email;

    @OneToMany(mappedBy = "mahasiswa")
    private List<MataKuliah> listMatKul = new ArrayList<>();

    @OneToMany(mappedBy = "mahasiswa")
    private List<Nilai> listNilai = new ArrayList<>();
}
