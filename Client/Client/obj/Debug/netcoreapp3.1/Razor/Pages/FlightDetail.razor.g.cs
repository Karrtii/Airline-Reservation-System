#pragma checksum "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "3317e60a9c5e684a4e724b1bb09ea8f3bedceae4"
// <auto-generated/>
#pragma warning disable 1591
namespace Client.Pages
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Client;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Client.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 10 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Radzen;

#line default
#line hidden
#nullable disable
#nullable restore
#line 11 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Radzen.Blazor;

#line default
#line hidden
#nullable disable
#nullable restore
#line 12 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Blazored;

#line default
#line hidden
#nullable disable
#nullable restore
#line 13 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Blazored.Toast;

#line default
#line hidden
#nullable disable
#nullable restore
#line 14 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\_Imports.razor"
using Blazored.Toast.Services;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
using Microsoft.AspNetCore.WebUtilities;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
using Client.Model;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
using Client.Data;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
using System.Net;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
using Client.Security;

#line default
#line hidden
#nullable disable
#nullable restore
#line 14 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
           [Authorize]

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/flightdetail")]
    public partial class FlightDetail : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
#nullable restore
#line 16 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
 if (flightInfo == null || from == null || whereTo == null || passenger == null || ticket == null)
{

#line default
#line hidden
#nullable disable
            __builder.AddContent(0, "    ");
            __builder.AddMarkupContent(1, "<p>Loading....</p>\r\n");
#nullable restore
#line 19 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
}
else
{

#line default
#line hidden
#nullable disable
            __builder.AddContent(2, "    ");
            __builder.OpenElement(3, "div");
            __builder.AddAttribute(4, "class", "container pt-3");
            __builder.AddMarkupContent(5, "\r\n        ");
            __builder.OpenElement(6, "div");
            __builder.AddAttribute(7, "class", "row justify-content-center");
            __builder.AddMarkupContent(8, "\r\n            ");
            __builder.OpenElement(9, "div");
            __builder.AddAttribute(10, "class", "detail-card");
            __builder.AddMarkupContent(11, "\r\n                ");
            __builder.OpenElement(12, "div");
            __builder.AddAttribute(13, "class", "first-half");
            __builder.AddMarkupContent(14, "\r\n                    ");
            __builder.AddMarkupContent(15, "<h1>Blazing flights</h1>\r\n                    ");
            __builder.OpenElement(16, "div");
            __builder.AddAttribute(17, "class", "flight-row");
            __builder.AddMarkupContent(18, "\r\n\r\n                        ");
            __builder.OpenElement(19, "span");
            __builder.AddContent(20, "Flight ");
            __builder.AddContent(21, 
#nullable restore
#line 29 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                                      flightID

#line default
#line hidden
#nullable disable
            );
            __builder.AddContent(22, " ");
            __builder.CloseElement();
            __builder.AddMarkupContent(23, "\r\n                        ");
            __builder.AddMarkupContent(24, "<span>/// </span>\r\n                        ");
            __builder.OpenElement(25, "span");
            __builder.AddContent(26, " ");
            __builder.AddContent(27, 
#nullable restore
#line 31 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                                flightInfo.departure.departureTime.ToString("dddd, dd MMMM yyyy")

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(28, "\r\n                        <i class=\"fas fa-circle\"></i>\r\n\r\n\r\n\r\n                    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(29, "\r\n\r\n                    ");
            __builder.OpenElement(30, "p");
            __builder.AddAttribute(31, "class", "mb-0");
            __builder.AddContent(32, 
#nullable restore
#line 38 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                                     passenger.firstname

#line default
#line hidden
#nullable disable
            );
            __builder.AddContent(33, " ");
            __builder.AddContent(34, 
#nullable restore
#line 38 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                                                          passenger.lastname

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(35, "\r\n\r\n                    ");
            __builder.AddMarkupContent(36, "<small>Passenger</small>\r\n                    ");
            __builder.OpenElement(37, "div");
            __builder.AddAttribute(38, "class", "row-row");
            __builder.AddMarkupContent(39, "\r\n                        ");
            __builder.OpenElement(40, "p");
            __builder.AddAttribute(41, "class", "mb-0 mt-2");
            __builder.AddContent(42, 
#nullable restore
#line 42 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                                              flightInfo.departure.departureTime.ToString("h: mm tt")

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(43, "\r\n                        ");
            __builder.OpenElement(44, "p");
            __builder.AddAttribute(45, "class", "mb-0 mt-2");
            __builder.AddContent(46, 
#nullable restore
#line 43 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                                              flightInfo.arrival.arrivalTime.ToString("h: mm tt")

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(47, "\r\n                        ");
            __builder.AddMarkupContent(48, "<small>DEPARTURE TIME</small>\r\n                        ");
            __builder.AddMarkupContent(49, "<small>LANDING TIME</small>\r\n\r\n                    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(50, "\r\n\r\n                    ");
            __builder.OpenElement(51, "div");
            __builder.AddAttribute(52, "class", "row-row-2");
            __builder.AddMarkupContent(53, "\r\n                        ");
            __builder.AddMarkupContent(54, "<p class=\"mb-0 mt-2\">One way</p>\r\n                        ");
            __builder.AddMarkupContent(55, "<p class=\"mb-0 mt-2\">15kg</p>\r\n                        ");
            __builder.OpenElement(56, "p");
            __builder.AddAttribute(57, "class", "mb-0 mt-2");
            __builder.AddContent(58, 
#nullable restore
#line 52 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                                              calculateSeat(ticket.seat)

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(59, "\r\n                        ");
            __builder.AddMarkupContent(60, "<small class=\"span\">FLIGHT TYPE</small>\r\n                        ");
            __builder.AddMarkupContent(61, "<small>LUGGAGE</small>\r\n                        ");
            __builder.AddMarkupContent(62, "<small>SEAT</small>\r\n\r\n                    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(63, "\r\n\r\n\r\n\r\n                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(64, "\r\n\r\n                ");
            __builder.OpenElement(65, "div");
            __builder.AddAttribute(66, "class", "second-half");
            __builder.AddMarkupContent(67, "\r\n                    ");
            __builder.OpenElement(68, "div");
            __builder.AddAttribute(69, "class", "left-side");
            __builder.AddMarkupContent(70, "\r\n                        <i class=\"fas fa-square\"></i>\r\n                        <i class=\"fas fa-caret-right\"></i>\r\n\r\n                        ");
            __builder.OpenElement(71, "h2");
            __builder.AddContent(72, 
#nullable restore
#line 68 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                             flightInfo.departure.fromWhere

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(73, "\r\n                        ");
            __builder.OpenElement(74, "p");
            __builder.AddContent(75, 
#nullable restore
#line 69 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                            from.city

#line default
#line hidden
#nullable disable
            );
            __builder.AddContent(76, ", ");
            __builder.AddContent(77, 
#nullable restore
#line 69 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                                        from.country

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(78, "\r\n                        ");
            __builder.OpenElement(79, "div");
            __builder.AddAttribute(80, "class", "inner-second-half");
            __builder.AddMarkupContent(81, "\r\n                            <i class=\"fas fa-caret-left\"></i>\r\n                            <i class=\"fas fa-grip-lines\"></i>\r\n\r\n\r\n                            <i class=\"fas fa-chevron-down\"></i>\r\n                            ");
            __builder.OpenElement(82, "h2");
            __builder.AddContent(83, 
#nullable restore
#line 76 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                                 flightInfo.arrival.fromWhere

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(84, "\r\n                            ");
            __builder.OpenElement(85, "p");
            __builder.AddContent(86, 
#nullable restore
#line 77 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                                whereTo.city

#line default
#line hidden
#nullable disable
            );
            __builder.AddContent(87, ", ");
            __builder.AddContent(88, 
#nullable restore
#line 77 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                                               whereTo.country

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(89, "\r\n                        ");
            __builder.CloseElement();
            __builder.AddMarkupContent(90, "\r\n                    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(91, "\r\n\r\n                    ");
            __builder.AddMarkupContent(92, "<div class=\"right-side\">\r\n                        <img src=\"/css/Assets/qr-code.svg\" alt=\"qr-code\">\r\n                    </div>\r\n\r\n                    ");
            __builder.OpenElement(93, "div");
            __builder.AddAttribute(94, "class", "row-2");
            __builder.AddMarkupContent(95, "\r\n                        ");
            __builder.OpenElement(96, "i");
            __builder.AddAttribute(97, "class", "fas fa-arrow-circle-left");
            __builder.AddAttribute(98, "style", "font-size:35px; cursor:pointer;");
            __builder.AddAttribute(99, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 86 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                                                                                                              goBack

#line default
#line hidden
#nullable disable
            ));
            __builder.CloseElement();
            __builder.AddMarkupContent(100, "\r\n                        ");
            __builder.OpenElement(101, "div");
            __builder.AddAttribute(102, "class", "booking-form p-0");
            __builder.AddMarkupContent(103, "\r\n                            ");
            __builder.OpenElement(104, "button");
            __builder.AddAttribute(105, "class", "submit-btn");
            __builder.AddAttribute(106, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 88 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
                                                                 CancelFlight

#line default
#line hidden
#nullable disable
            ));
            __builder.AddContent(107, "Cancel flight");
            __builder.CloseElement();
            __builder.AddMarkupContent(108, "\r\n                        ");
            __builder.CloseElement();
            __builder.AddMarkupContent(109, "\r\n                    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(110, "\r\n                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(111, "\r\n            ");
            __builder.CloseElement();
            __builder.AddMarkupContent(112, "\r\n        ");
            __builder.CloseElement();
            __builder.AddMarkupContent(113, "\r\n    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(114, "\r\n");
#nullable restore
#line 95 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
}

#line default
#line hidden
#nullable disable
        }
        #pragma warning restore 1998
#nullable restore
#line 97 "C:\Users\karrt\Desktop\All_Folders\Uni\Semester3\Semester Project Heterogeneous System (SEP3)\1 SEP3\SEP3XA20-ARS\Client\Client\Pages\FlightDetail.razor"
       
    private int flightID;
    private int passengerNum;
    private FlightInfo flightInfo;
    private Passenger passenger;
    private Airport from;
    private Airport whereTo;
    private Ticket ticket;

    protected async override Task OnInitializedAsync()
    {
        var uri = navigationManager.ToAbsoluteUri(navigationManager.Uri);

        if (QueryHelpers.ParseQuery(uri.Query).TryGetValue(securityService.passengerPassportFlightDetails, out var passengerNum))
        {
            this.passengerNum = Convert.ToInt32(customDataProtection.Decode(passengerNum.First()));
        }

        if (QueryHelpers.ParseQuery(uri.Query).TryGetValue(securityService.flightIDFlightDetails, out var flightid))
        {
            flightID = Convert.ToInt32(customDataProtection.Decode(flightid.First()));
        }

        flightInfo = await flightInfoService.getFlightInfo(flightID);
        from = await airportService.getAirportByIATA(flightInfo.departure.fromWhere);
        whereTo = await airportService.getAirportByIATA(flightInfo.arrival.fromWhere);
        passenger = await passengerService.getPassenger(this.passengerNum);
        ticket = await ticketService.getTicket(this.passengerNum, flightID);
    }
    private void goBack()
    {
        navigationManager.NavigateTo("/viewmyflights");
    }
    private string calculateSeat(int seatnumber)
    {
        int row = seatnumber / 6;
        string result = "";
        switch (seatnumber % 6)
        {
            case 0:
                result = row + "F";
                break;
            case 1:
                result = row + "E";
                break;
            case 2:
                result = row + "D";
                break;
            case 3:
                result = row + "C";
                break;
            case 4:
                result = row + "B";
                break;
            case 5:
                result = row + "A";
                break;
        }
        return result;
    }
    private async Task CancelFlight()
    {
        await ticketService.cancelFlight(this.passengerNum, flightID);
        navigationManager.NavigateTo("/viewmyflights");
    }

#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private CustomDataProtection customDataProtection { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private ITicketService ticketService { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private SecurityService securityService { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IPassengerService passengerService { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IAirportService airportService { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IFlightInfoService flightInfoService { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager navigationManager { get; set; }
    }
}
#pragma warning restore 1591
