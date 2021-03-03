using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using Client.CustomValidation;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace Client.Model
{
    public class User
    {
        [JsonPropertyName("userType")]
        public string userType { get; set; }
        [JsonPropertyName("email")]
        [Required (ErrorMessage = "Please enter your email")]
        [EmailAddress(ErrorMessage = "Please enter your email adress in format: yourname@example.com")]
        public string email { get; set; }
        [JsonPropertyName("password")]
        [StringLength(16, ErrorMessage = "{0} length must be between {2} and {1}.", MinimumLength = 6)]
        [Required(ErrorMessage = "Please enter your password")]
        public string password { get; set; }
        [JsonPropertyName("firstName")]
        [Required(ErrorMessage = "Please enter your name")]
        public string firstName { get; set; }
        [JsonPropertyName("lastName")]
        [Required(ErrorMessage = "Please enter your surname")]
        public string lastName { get; set; }
        [JsonPropertyName("dateOfBirth")]
        [Required(ErrorMessage = "Please enter your date of birth")]
        [CorrectDate]
        public DateTime dateOfBirth { get; set; }
        [JsonPropertyName("phoneNumber")]
        [Required(ErrorMessage = "Please enter your phone number")]
        [Range(10000000,999999999,ErrorMessage ="Please enter a phone number in format: 123456789 or 12345678")]
        public int phoneNumber { get; set; }

        public User()
        { }

        public User(string userType, string email, string password, string firstName, string lastName, DateTime dateOfBirth, int phoneNumber)
        {
            this.userType = userType;
            this.email = email;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
            this.phoneNumber = phoneNumber;
        }
    }
    
}
