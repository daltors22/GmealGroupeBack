package group.aca.api.Service;

import group.aca.api.Entity.Logs;
import group.aca.api.Repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsService {

    @Autowired
    private LogsRepository logsRepository;

    public List<Logs> getAllLogs() {
        return logsRepository.findAll();
    }

    public Logs getLogById(Integer id) {
        return logsRepository.findById(id).orElse(null);
    }

    public Logs createOrUpdateLog(Logs log) {
        return logsRepository.save(log);
    }

    public void deleteLog(Integer id) {
        logsRepository.deleteById(id);
    }
}
