using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Client.Data;
using Client.Security;
using Client.Data.Implementation;
using Microsoft.AspNetCore.Components.Authorization;
using Client.Authentication;
using Blazored.Toast;

namespace Client
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        // For more information on how to configure your application, visit https://go.microsoft.com/fwlink/?LinkID=398940

        public class UniqueCode
        {
            public readonly string FlightIDRouteValue = "FlightSystemRouteValue";
        }

        public void ConfigureServices(IServiceCollection services)
        {
            services.AddRazorPages();
            services.AddServerSideBlazor();
            services.AddSingleton<UniqueCode>();
            services.AddSingleton<CustomDataProtection>();
            services.AddSingleton<SecurityService>();
            services.AddScoped<IUserService, CloudUserService>();
            services.AddScoped<IFlightService, CloudFlightService>();
            services.AddScoped<IAirplaneService, CloudAirplaneService>();
            services.AddScoped<AuthenticationStateProvider, CustomAuthenticationStateProvider>();
            services.AddScoped<IAirportService, CloudAirportService>();
            services.AddScoped<IFlightInfoService, CloudFlightInfoService>();
            services.AddScoped<IPassengerService, CloudPassengerService>();
            services.AddScoped<ITicketService, CloudTicketService>();
            services.AddBlazoredToast();
            services.AddSingleton<IBookingService,BookingService>();
            services.AddAuthorization(options => {
                options.AddPolicy("MustBeOperator", a =>
                a.RequireAuthenticatedUser().RequireClaim("UserType", "operator"));

                options.AddPolicy("MustBeCustomer", a =>
                a.RequireAuthenticatedUser().RequireClaim("UserType", "customer"));
            });
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseStaticFiles();

            app.UseRouting();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapBlazorHub();
                endpoints.MapFallbackToPage("/_Host");
            });
        }
    }
}
