using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using Client.CustomValidation;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace Client.Model
{
    public class Passenger
    {


        [JsonPropertyName("passportNumber")]
        [Range(1000000000,9999999999,ErrorMessage = "Wrong passport format")]
        [Required]
        public int passportNumber { get; set; }
        [JsonPropertyName("passportExpirationDate")]
        [Required]
        [SearchDate]
        public DateTime passportExpirationDate { get; set; }
        [Required]
        [JsonPropertyName("firstname")]
        public string firstname { get; set; }
        [Required]
        [JsonPropertyName("lastname")]
        public string lastname { get; set; }
        [Required]
        [JsonPropertyName("dateOfBirth")]
        [CorrectDate]
        public DateTime dateOfBirth { get; set; }
        [Required]
        [StringLength(1)]
        [JsonPropertyName("gender")]
        public string gender { get; set; }
        [Required]
        [JsonPropertyName("nationality")]
        public string nationality { get; set; }

        public Passenger(int passportNumber, DateTime passportExpirationDate, string firstname, string lastname, DateTime dateOfBirth, string gender, string nationality)
        {
            this.passportNumber = passportNumber;
            this.passportExpirationDate = passportExpirationDate;
            this.firstname = firstname;
            this.lastname = lastname;
            this.dateOfBirth = dateOfBirth;
            this.gender = gender;
            this.nationality = nationality;
        }

        public Passenger()
        {

        }

        public override string ToString()
        {
            return "PassportNumber: " + passportNumber + " PassportExpirationDate: " + passportExpirationDate + " Name: " +
                firstname + " LastName: " + lastname + " DateOfBirth: " + dateOfBirth + " Gender: " + gender + " Nationality: " + nationality;
        }
    }
}
