import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminUpdateComponent } from './admin-update/admin-update.component';
import { AdminpanelComponent } from './adminpanel/adminpanel.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { CreateAirportComponent } from './create-airport/create-airport.component';
import { CreateBookingComponent } from './create-booking/create-booking.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { CustSearchBookingDescComponent } from './cust-search-booking-desc/cust-search-booking-desc.component';
import { GetAllAirportsComponent } from './get-all-airports/get-all-airports.component';
import { GetAllBookingsComponent } from './get-all-bookings/get-all-bookings.component';
import { GetAllFlightsComponent } from './get-all-flights/get-all-flights.component';
import { GetAllUsersComponent } from './get-all-users/get-all-users.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SearchAirportByParamsComponent } from './search-airport-by-params/search-airport-by-params.component';
import { SearchAirportComponent } from './search-airport/search-airport.component';
import { SearchBookingByParamsComponent } from './search-booking-by-params/search-booking-by-params.component';
import { SearchBookingDescComponent } from './search-booking-desc/search-booking-desc.component';
import { SearchBookingComponent } from './search-booking/search-booking.component';
import { SearchFlightByCarrierComponent } from './search-flight-by-carrier/search-flight-by-carrier.component';
import { SearchFlightByRouteComponent } from './search-flight-by-route/search-flight-by-route.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { SearchUserByNameComponent } from './search-user-by-name/search-user-by-name.component';
import { SearchUserComponent } from './search-user/search-user.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { UpdateBookingComponent } from './update-booking/update-booking.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserpanelComponent } from './userpanel/userpanel.component';

const routes: Routes = [

  /* HOME */
  {path:"home", component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'contactUs', component: ContactUsComponent},
  {path:'register', component: RegisterComponent},

  /* ADMIN PANEL */
  {path:"adminPanel", redirectTo: "home", pathMatch:"full"},
  {path:'adminPanel/:id', component: AdminpanelComponent},
  {path:'adminUpdate/:id', component: AdminUpdateComponent},
  
  /* USER PANEL */
  {path:"userPanel", redirectTo: "home", pathMatch:"full"},  
  {path:'userPanel/:id', component: UserpanelComponent},
  {path:'cust-search-booking-desc/:id/:uid', component: CustSearchBookingDescComponent},

  /* USER SERVICE */
  {path:'list-users/:id', component: GetAllUsersComponent},
  {path:'create-user/:id', component: CreateUserComponent},
  {path:'update-user/:id/:uid', component: UpdateUserComponent},
  {path:'search-user/:id/:uid', component: SearchUserComponent},
  {path:'search-user-by-name/:id', component: SearchUserByNameComponent},
  
  /* AIRPORT SERVICE */
  {path:'list-airports/:id', component: GetAllAirportsComponent},
  {path:'create-airport/:id', component: CreateAirportComponent},
  {path:'update-airport/:id/:uid', component: UpdateAirportComponent},  
  {path:'search-airport/:id/:uid', component: SearchAirportComponent},
  {path:'search-airport-by-params/:id', component: SearchAirportByParamsComponent},
  
  /* FLIGHT SERVICE */
  {path:'list-flights/:id', component: GetAllFlightsComponent},
  {path:'create-flight/:id', component: CreateFlightComponent},
  {path:'update-flight/:id/:uid', component: UpdateFlightComponent},
  {path:'search-flight/:id/:uid', component: SearchFlightComponent},
  {path:'search-flight-by-carrier/:id', component: SearchFlightByCarrierComponent},
  {path:'get-flight-route-details/:id/:uid', component: SearchFlightByRouteComponent},

  /* BOOKING SERVICE */
  {path:'list-bookings/:id', component: GetAllBookingsComponent},
  {path:'create-booking/:id', component: CreateBookingComponent},
  {path:'update-booking/:id/:uid', component: UpdateBookingComponent},
  {path:'search-booking/:id/:uid', component: SearchBookingComponent},
  {path:'search-bookings-by-params/:id', component: SearchBookingByParamsComponent},
  {path:'get-booking-desc/:id/:uid', component: SearchBookingDescComponent},
  
  /* OTHER */
  {path:"", redirectTo: "home", pathMatch:"full"},
  {path:"**", component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
