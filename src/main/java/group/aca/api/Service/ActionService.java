package group.aca.api.Service;

import group.aca.api.Entity.Action;
import group.aca.api.Repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    public Action getActionById(Integer id) {
        return actionRepository.findById(id).orElse(null);
    }

    public Action createAction(Action action) {
        return actionRepository.save(action);
    }

    public void deleteAction(Integer id) {
        actionRepository.deleteById(id);
    }
}
