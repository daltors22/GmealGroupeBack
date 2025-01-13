package group.aca.api.Service;

import group.aca.api.Entity.Photo;
import group.aca.api.Repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    public Photo getPhotoById(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public Photo createOrUpdatePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public void deletePhoto(Integer id) {
        photoRepository.deleteById(id);
    }
}
