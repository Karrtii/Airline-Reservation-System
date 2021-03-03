using Client.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Client.Data
{
    public interface IUserService
    {
        Task<User> ValidateUser(string email, string password);
        Task<User> RegisterUser(User newUser);
        Task<User> getUser(string email);
        Task<User> ModifyUser(User newUser,string oldEmail);
    }
}
