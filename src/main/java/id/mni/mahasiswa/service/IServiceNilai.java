package id.mni.mahasiswa.service;

import id.mni.mahasiswa.dto.GetMahasiswaDto;
import id.mni.mahasiswa.dto.GetNilaiRataMahasiswaDto;
import id.mni.mahasiswa.dto.NilaiDto;
import id.mni.mahasiswa.dto.UpdateNilaiDto;
import id.mni.mahasiswa.model.Nilai;

import java.util.List;

public interface IServiceNilai {
    Nilai save(NilaiDto nilai);
    List<GetMahasiswaDto> getMahasiswa();
    Nilai delete(Integer nilaiId);
    Nilai updateNilaiMahasiswa(UpdateNilaiDto updateNilaiDto);
    List<GetNilaiRataMahasiswaDto> getNilaiRataMahasiswa();
}
