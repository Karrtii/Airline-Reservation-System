using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Client.CustomValidation
{
    public class SearchDate : ValidationAttribute
    {
        public SearchDate() { }

        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            var date = (DateTime)value;
            if (DateTime.Compare(date, DateTime.Now) > 0)
            {
                return ValidationResult.Success;
            }
            return new ValidationResult("Please enter valid departure date",
                new[] { validationContext.MemberName });
        }
    }
}
