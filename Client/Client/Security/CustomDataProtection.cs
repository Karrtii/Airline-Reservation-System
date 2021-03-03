using Microsoft.AspNetCore.DataProtection;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using static Client.Startup;

namespace Client.Security
{
    public class CustomDataProtection
    {
        private readonly IDataProtector protector;

        public CustomDataProtection(IDataProtectionProvider dataProtectionProvider,UniqueCode uniqueCode) 
        {
            protector = dataProtectionProvider.CreateProtector(uniqueCode.FlightIDRouteValue);
        }

        public string Decode(string data)
        {
            return protector.Unprotect(data);
        }
        public string Encode(string data)
        {
            return protector.Protect(data);
        }
    }
}
