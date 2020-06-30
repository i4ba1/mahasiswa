package id.mni.mahasiswa.service.impl;

import id.mni.mahasiswa.dto.GetMahasiswaDto;
import id.mni.mahasiswa.dto.GetNilaiRataMahasiswaDto;
import id.mni.mahasiswa.dto.NilaiDto;
import id.mni.mahasiswa.dto.UpdateNilaiDto;
import id.mni.mahasiswa.model.Mahasiswa;
import id.mni.mahasiswa.model.MataKuliah;
import id.mni.mahasiswa.model.Nilai;
import id.mni.mahasiswa.repository.IRepositoryMahasiswa;
import id.mni.mahasiswa.repository.IRepositoryMataKuliah;
import id.mni.mahasiswa.repository.IRepositoryNilai;
import id.mni.mahasiswa.service.IServiceNilai;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceNilaiImpl implements IServiceNilai {

    private final IRepositoryNilai repositoryNilai;
    private final IRepositoryMataKuliah repositoryMataKuliah;
    private final IRepositoryMahasiswa repositoryMahasiswa;


    public ServiceNilaiImpl(IRepositoryNilai repositoryNilai, IRepositoryMataKuliah repositoryMataKuliah, IRepositoryMahasiswa repositoryMahasiswa) {
        this.repositoryNilai = repositoryNilai;
        this.repositoryMataKuliah = repositoryMataKuliah;
        this.repositoryMahasiswa = repositoryMahasiswa;
    }

    @Override
    public Nilai save(NilaiDto nilai) {
        Optional<MataKuliah> optionalMataKuliah = repositoryMataKuliah.findById(nilai.getMahasiswaId());
        MataKuliah mataKuliah = null;
        if (optionalMataKuliah.isPresent()) {
            mataKuliah = optionalMataKuliah.get();
        }

        Optional<Mahasiswa> optionalMahasiswa = repositoryMahasiswa.findById(nilai.getMahasiswaId());
        Mahasiswa mahasiswa = null;
        if (optionalMahasiswa.isPresent()) {
            mahasiswa = optionalMahasiswa.get();
        }

        Nilai newNilai = new Nilai();
        newNilai.setNilai(nilai.getNilai());
        newNilai.setKeterangan(nilai.getKeterangan());
        newNilai.setMahasiswa(mahasiswa);
        newNilai.setMataKuliah(mataKuliah);

        return repositoryNilai.save(newNilai);
    }

    @Override
    public List<GetMahasiswaDto> getMahasiswa() {
        List<Mahasiswa> listMahasiswa = repositoryMahasiswa.findAll();
        List<GetMahasiswaDto> listNilaiMahasiswa = new ArrayList<>();

        List<Mahasiswa> mahasiswaList = new ArrayList<>();
        for (Mahasiswa m:mahasiswaList) {
            GetMahasiswaDto getMahasiswaDto = new GetMahasiswaDto();
            List<MataKuliah> mataKuliahList = repositoryMataKuliah.findMataKuliahByMahasiswa(m.getId());
            List<Nilai> nilaiList = repositoryNilai.findNilaiByMahasiswa(m.getId());;

            for (int i=0; i<mahasiswaList.size() && i < nilaiList.size(); i++) {
                getMahasiswaDto.setNim(m.getNim());
                getMahasiswaDto.setName(m.getFirstName()+" "+m.getLastName());
                getMahasiswaDto.setMatkul(mataKuliahList.get(i).getMataKuliah());
                getMahasiswaDto.setNilai(nilaiList.get(i).getNilai());
                listNilaiMahasiswa.add(getMahasiswaDto);
            }
        }

        return listNilaiMahasiswa;

        /*for (Mahasiswa m:listMahasiswa) {
            List<MataKuliah> listMatKul = repositoryMataKuliah.findMataKuliahByMahasiswa(m.getId());
            List<Nilai>

            for (MataKuliah matkul:m.getListMatKul()) {
                GetMahasiswaDto getMahasiswaDto = new GetMahasiswaDto();
                getMahasiswaDto.setNim(m.getNim());
                getMahasiswaDto.setName(m.getFirstName()+" "+m.getLastName());
                getMahasiswaDto.setMatkul(matkul.getMataKuliah());
            }
        }*/
    }

    @Override
    public Nilai delete(Integer nilaiId) {
        Optional<Nilai> optionalNilai = repositoryNilai.findById(nilaiId);
        optionalNilai.ifPresent(repositoryNilai::delete);
        return null;
    }

    @Override
    public Nilai updateNilaiMahasiswa(UpdateNilaiDto updateNilaiDto) {
        Optional<Nilai> optionalNilai = repositoryNilai.findById(updateNilaiDto.getNilaiId());
        if (!optionalNilai.isPresent()) {
            return null;
        }
        Nilai currentMahasiswaNilai = optionalNilai.get();
        currentMahasiswaNilai.setNilai(updateNilaiDto.getNilai());
        return repositoryNilai.saveAndFlush(currentMahasiswaNilai);
    }

    @Override
    public List<GetNilaiRataMahasiswaDto> getNilaiRataMahasiswa() {
        List<Mahasiswa> mahasiswaList = repositoryMahasiswa.findAll();
        for (int i = 0; i < mahasiswaList.size(); i++) {

        }

        List<GetNilaiRataMahasiswaDto> result = new ArrayList<>();
        for(Mahasiswa mhs:mahasiswaList){
            GetNilaiRataMahasiswaDto dto = new GetNilaiRataMahasiswaDto();
            dto.setNim(mhs.getNim());
            dto.setFullName(mhs.getFirstName()+" "+ mhs.getLastName());
            List<Nilai> nilaiList = repositoryNilai.findNilaiByMahasiswa(mhs.getId());

            int totalDataNilai = nilaiList.size();
            double sum = 0;
            for (Nilai nilai:nilaiList) {
                sum += nilai.getNilai();
            }
            sum = sum/totalDataNilai;
            dto.setNilaiRata(sum);
            result.add(dto);
        }
        return result;
    }

}
