package id.mni.mahasiswa.repository;

import id.mni.mahasiswa.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryMahasiswa extends JpaRepository<Mahasiswa, Integer> {
    //@Query("select m from Mahasiswa m join fetch m.listMatKul join fetch m.listNilai")
    //List<Mahasiswa> getDataMahasiswa();

    //@Query("select m from Mahasiswa m join fetch m.listNilai")
    //List<Mahasiswa> getNilaiRataMahasiswa();
}
