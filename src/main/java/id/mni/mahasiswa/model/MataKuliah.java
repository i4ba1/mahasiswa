package id.mni.mahasiswa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_mata_kuliah")
@Data
public class MataKuliah {
    @Id
    @SequenceGenerator(name = "NATKUL_SEQ",sequenceName = "matkul_seq",
            initialValue = 5, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NATKUL_SEQ")
    private Integer id;

    @Column(name = "mata_kuliah", columnDefinition = "varchar(128)")
    private String mataKuliah;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mahasiswa_id", nullable = false)
    private Mahasiswa mahasiswa;

    @OneToMany(mappedBy = "mataKuliah")
    private List<Nilai> listNilai = new ArrayList<>();
}
