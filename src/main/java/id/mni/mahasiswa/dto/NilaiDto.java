package id.mni.mahasiswa.dto;

import lombok.Data;

@Data
public class NilaiDto {
    private Integer mahasiswaId;
    private Integer mataKuliahId;
    private Double nilai;
    private String keterangan;
}
