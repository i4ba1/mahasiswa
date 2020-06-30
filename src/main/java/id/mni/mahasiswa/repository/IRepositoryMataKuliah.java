package id.mni.mahasiswa.repository;

import id.mni.mahasiswa.model.MataKuliah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRepositoryMataKuliah extends JpaRepository<MataKuliah, Integer> {
    @Query("select mk from MataKuliah mk where mk.mahasiswa.id = ?1")
    List<MataKuliah> findMataKuliahByMahasiswa(Integer id);
}
