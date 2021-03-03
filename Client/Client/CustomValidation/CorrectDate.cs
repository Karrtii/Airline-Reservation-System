using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace Client.CustomValidation
{
    public class CorrectDate : ValidationAttribute
    {
        public CorrectDate() { }


        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            var date = (DateTime)value;
            if (DateTime.Compare(date, DateTime.Now) < 0 && DateTime.Compare(date,new DateTime(1900,1,1)) > 0)
            {
                return ValidationResult.Success;
            }
            return new ValidationResult("Please enter valid date of birth",
                new[] { validationContext.MemberName });
        }
    }
}
