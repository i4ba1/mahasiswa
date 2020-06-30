package id.mni.mahasiswa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_nilai")
@Data
public class Nilai {
    @Id
    @SequenceGenerator(name = "NILAI_SEQ",sequenceName = "nilai_seq",
            initialValue = 5, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NILAI_SEQ")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mahasiswa_id", nullable = false)
    private Mahasiswa mahasiswa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mata_kuliah_id", nullable = false)
    private MataKuliah mataKuliah;

    @Column(name = "nilai", columnDefinition = "float")
    private Double nilai;

    @Column(name = "keterangan", columnDefinition = "varchar(100)")
    private String keterangan;
}
