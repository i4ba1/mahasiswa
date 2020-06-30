package id.mni.mahasiswa.dto;

import lombok.Data;

@Data
public class GetNilaiRataMahasiswaDto {
    private String nim;
    private String fullName;
    private Double nilaiRata;
}
