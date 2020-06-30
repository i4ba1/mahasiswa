package id.mni.mahasiswa.dto;

import lombok.Data;

@Data
public class GetMahasiswaDto {
    private String nim;
    private String name;
    private String matkul;
    private Double nilai;
}
