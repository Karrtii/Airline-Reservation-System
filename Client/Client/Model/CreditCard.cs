using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Client.Model
{
    public class CreditCard
    {
        public CreditCard(long creditCardNumber, string expirationDate, int cvv)
        {
            this.creditCardNumber = creditCardNumber;
            this.expirationDate = expirationDate;
            this.cvv = cvv;
        }

        long creditCardNumber { get; set; }
        string expirationDate { get; set; }
        int cvv { get; set; }


    }
}
