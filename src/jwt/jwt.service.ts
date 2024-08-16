import { Inject, Injectable } from '@nestjs/common';
import { JwtModuleOptions } from './jwt.interfaces';
import { CONFIG_OPTIONS } from './jwt.constants';
import * as Jwt from 'jsonwebtoken';

@Injectable()
export class JwtService {
  constructor(
    @Inject(CONFIG_OPTIONS) private readonly options: JwtModuleOptions,
  ) {}

  sign(userId: number): string {
    return Jwt.sign({ id: userId }, this.options.privateKey);
  }
}
