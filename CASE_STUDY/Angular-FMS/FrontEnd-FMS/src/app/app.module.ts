import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { CreateUserComponent } from './create-user/create-user.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { SearchUserComponent } from './search-user/search-user.component';
import { GetAllUsersComponent } from './get-all-users/get-all-users.component';
import { UserpanelComponent } from './userpanel/userpanel.component';
import { AdminpanelComponent } from './adminpanel/adminpanel.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { SearchUserByNameComponent } from './search-user-by-name/search-user-by-name.component';
import { GetAllAirportsComponent } from './get-all-airports/get-all-airports.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { SearchAirportComponent } from './search-airport/search-airport.component';
import { CreateAirportComponent } from './create-airport/create-airport.component';
import { SearchAirportByParamsComponent } from './search-airport-by-params/search-airport-by-params.component';
import { GetAllFlightsComponent } from './get-all-flights/get-all-flights.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { SearchFlightByCarrierComponent } from './search-flight-by-carrier/search-flight-by-carrier.component';
import { SearchFlightByRouteComponent } from './search-flight-by-route/search-flight-by-route.component';
import { GetAllBookingsComponent } from './get-all-bookings/get-all-bookings.component';
import { CreateBookingComponent } from './create-booking/create-booking.component';
import { SearchBookingComponent } from './search-booking/search-booking.component';
import { SearchBookingByParamsComponent } from './search-booking-by-params/search-booking-by-params.component';
import { UpdateBookingComponent } from './update-booking/update-booking.component';
import { SearchBookingDescComponent } from './search-booking-desc/search-booking-desc.component';
import { CustSearchBookingDescComponent } from './cust-search-booking-desc/cust-search-booking-desc.component';
import { AdminUpdateComponent } from './admin-update/admin-update.component';


@NgModule({
  declarations: [
    
    /* HOME */
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ContactUsComponent,

    /* ADMIN PANEL */
    AdminpanelComponent,
    AdminUpdateComponent,
    
    /* USER PANEL */
    UserpanelComponent,
    CustSearchBookingDescComponent,
    
    /* USER SERVICE */
    CreateUserComponent,
    UpdateUserComponent,
    SearchUserComponent,
    GetAllUsersComponent,
    SearchUserByNameComponent,
    
    /* AIRPORT SERVICE */
    GetAllAirportsComponent,
    UpdateAirportComponent,
    SearchAirportComponent,
    CreateAirportComponent,
    SearchAirportByParamsComponent,
    
    /* FLIGHT SERVICE */
    GetAllFlightsComponent,
    CreateFlightComponent,
    UpdateFlightComponent,
    SearchFlightComponent,
    SearchFlightByCarrierComponent,
    SearchFlightByRouteComponent,
    
    /* BOOKING SERVICE */
    GetAllBookingsComponent,
    CreateBookingComponent,
    UpdateBookingComponent,
    SearchBookingComponent,
    SearchBookingByParamsComponent,
    SearchBookingDescComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
