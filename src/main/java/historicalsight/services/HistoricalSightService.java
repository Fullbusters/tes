package historicalsight.services;


import com.historicalsight.models.HistoricalSight;
import com.historicalsight.repository.HistoricalSightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricalSightService {

    @Autowired
    private HistoricalSightRepository historicalSightRepository;

    public List<HistoricalSight> findAll(){
        return historicalSightRepository.findAll();
    }

    public HistoricalSight findOne(Long id){
        return historicalSightRepository.getOne(id);
    }

    public HistoricalSight save(HistoricalSight historicalSight){
        return historicalSightRepository.save(historicalSight);
    }

    public void delete(Long id){
        historicalSightRepository.delete(id);
    }

    public List<HistoricalSight> getHistoricalSight(Long id){
        return historicalSightRepository.getHistoricalSight(id);
    }
}
