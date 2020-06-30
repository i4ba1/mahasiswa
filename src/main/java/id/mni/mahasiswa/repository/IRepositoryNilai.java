package id.mni.mahasiswa.repository;

import id.mni.mahasiswa.model.Nilai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRepositoryNilai extends JpaRepository<Nilai, Integer> {

    @Query("select n from Nilai n where n.mahasiswa.id = ?1")
    List<Nilai> findNilaiByMahasiswa(Integer id);
}
