package historicalsight.services;

import com.historicalsight.models.Info;
import com.historicalsight.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public List<Info> getAll(){
        return infoRepository.findAll();
    }

    public Info getOne(Long id){
        return infoRepository.getOne(id);
    }

    public Info save(Info info){
        return infoRepository.save(info);
    }

    public void delete(Long id){
        infoRepository.delete(id);
    }
}
