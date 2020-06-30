package id.mni.mahasiswa.controller;

import id.mni.mahasiswa.dto.GetMahasiswaDto;
import id.mni.mahasiswa.dto.GetNilaiRataMahasiswaDto;
import id.mni.mahasiswa.dto.NilaiDto;
import id.mni.mahasiswa.dto.UpdateNilaiDto;
import id.mni.mahasiswa.model.Nilai;
import id.mni.mahasiswa.service.IServiceNilai;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mhs")
public class MahasiswaController {
    private final IServiceNilai serviceNilai;

    public MahasiswaController(IServiceNilai serviceNilai) {
        this.serviceNilai = serviceNilai;
    }

    @PostMapping("/saveNilai")
    public ResponseEntity<Void> saveNilai(@RequestBody NilaiDto nilaiDto){
        Nilai nilai = serviceNilai.save(nilaiDto);
        if (nilai == null) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getMahasiswa")
    public ResponseEntity<List<GetMahasiswaDto>> getMahasiswa(){
        List<GetMahasiswaDto> getMahasiswaDtoList = serviceNilai.getMahasiswa();
        if (getMahasiswaDtoList.isEmpty()) {
            return new ResponseEntity<>(getMahasiswaDtoList, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(getMahasiswaDtoList, HttpStatus.OK);
    }

    @GetMapping("/nilaiRata")
    public ResponseEntity<List<GetNilaiRataMahasiswaDto>> getNilaiRataMahasiswa(){
        List<GetNilaiRataMahasiswaDto> result = serviceNilai.getNilaiRataMahasiswa();
        if (result == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/deleteNilai/{id}")
    public ResponseEntity<Void> deleteNilai(@PathVariable(value = "id") Integer nilaiId){
        if(serviceNilai.delete(nilaiId) == null){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/updateNilai")
    public ResponseEntity<Void> updateNilai(@RequestBody UpdateNilaiDto updateNilaiDto){
        Nilai updatedNilai = serviceNilai.updateNilaiMahasiswa(updateNilaiDto);
        if (updatedNilai == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
