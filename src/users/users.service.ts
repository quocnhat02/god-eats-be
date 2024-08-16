import { CreateAccountInput } from './dtos/create-account.dto';
import { InjectRepository } from '@nestjs/typeorm';
import { User } from './entities/user.entity';
import { Repository } from 'typeorm';
import { Injectable } from '@nestjs/common';

@Injectable()
export class UsersService {
  constructor(
    @InjectRepository(User)
    private readonly users: Repository<User>,
  ) {}

  async createAccount({ email, password, role }: CreateAccountInput) {
    try {
      const exists = await this.users.findOne({
        where: {
          email,
        },
      });

      if (exists) {
        return;
      }

      await this.users.save(this.users.create({ email, password, role }));

      return true;
    } catch (error) {
      console.log(error);

      return;
    }
  }
}
