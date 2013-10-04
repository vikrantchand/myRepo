package training.impetus.tp.services;

import org.springframework.stereotype.Component;
import training.impetus.tp.model.UserEntity;

@Component
public abstract interface UserService
{
  public abstract boolean createUser(UserEntity paramUserEntity);

}