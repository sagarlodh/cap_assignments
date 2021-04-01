import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddfoodComponent } from './addfood/addfood.component';
import { AddrestComponent } from './addrest/addrest.component';
import { AdminComponent } from './admin/admin.component';
import { DeletefoodComponent } from './deletefood/deletefood.component';
import { DeleterestComponent } from './deleterest/deleterest.component';
import { EditfoodComponent } from './editfood/editfood.component';
import { EditrestComponent } from './editrest/editrest.component';
import { MenuComponent } from './menu/menu.component';
import { MenudetailComponent } from './menudetail/menudetail.component';
import { OrderfoodComponent } from './orderfood/orderfood.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { RestaurantdetailComponent } from './restaurantdetail/restaurantdetail.component';
import { UmenuComponent } from './umenu/umenu.component';
import { UmenudetailComponent } from './umenudetail/umenudetail.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path:'',redirectTo:'/user',pathMatch:'full'},
  {path:'admin', component: AdminComponent},
  {path:'user', component: UserComponent},
  {path:'menu', component: MenuComponent},
  {path:'menu/:id/:food', component: MenudetailComponent},
  {path:'addfood', component: AddfoodComponent},
  {path:'editfood', component: EditfoodComponent},
  {path:'deletefood', component: DeletefoodComponent},
  {path:'restaurant', component: RestaurantComponent},
  {path:'restaurant/:id/:rest', component: RestaurantdetailComponent},
  {path:'addrestaurant', component: AddrestComponent},
  {path:'editrestaurant', component: EditrestComponent},
  {path:'deleterestaurant', component: DeleterestComponent},
  {path:'umenu', component: UmenuComponent},
  {path:'umenu/:id', component: UmenudetailComponent},
  {path:'orderfood', component: OrderfoodComponent},
  {path:'**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [
  AdminComponent,
  UserComponent,
  MenuComponent,
  MenudetailComponent,
  AddfoodComponent,
  EditfoodComponent,
  DeletefoodComponent,
  RestaurantComponent,
  RestaurantdetailComponent,
  AddrestComponent,
  EditrestComponent,
  DeleterestComponent,
  UmenuComponent,
  UmenudetailComponent,
  OrderfoodComponent,
  PageNotFoundComponent
]