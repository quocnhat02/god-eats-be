import { RestaurantsService } from './restaurants.service';
import { Args, Mutation, Query, Resolver } from '@nestjs/graphql';
import { Restaurant } from './entities/restaurant.entity';
import { CreateRestaurantDto } from './dtos/create-restaurant.dto';

@Resolver((of) => Restaurant)
export class RestaurantsResolver {
  constructor(private readonly restaurantsService: RestaurantsService) {}

  @Query((returns) => [Restaurant])
  restaurants(): Promise<Restaurant[]> {
    return this.restaurantsService.getAll();
  }

  @Mutation((returns) => Boolean)
  async createRestaurant(
    @Args('input') createRestaurantDto: CreateRestaurantDto,
  ): Promise<boolean> {
    try {
      await this.restaurantsService.createRestaurant(createRestaurantDto);

      return true;
    } catch (error) {
      console.log(error);
      return false;
    }
  }
}
