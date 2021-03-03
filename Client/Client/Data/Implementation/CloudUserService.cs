using Client.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Runtime.Serialization;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace Client.Data.Implementation
{
    public class CloudUserService : IUserService
    {
        private HttpClient client = new HttpClient();

        public async Task<User> getUser(string email)
        {
            HttpResponseMessage message = await client.GetAsync("https://localhost:8443/users/?email=" + email);
            return await handleMessageFromMiddleware(message);
        }

        public async Task<User> ModifyUser(User newUser, string oldEmail)
        {
            HttpContent content = new StringContent(JsonSerializer.Serialize(newUser), Encoding.UTF8, "application/json");
            HttpResponseMessage message = await client.PatchAsync("https://localhost:8443/users?oldEmail="+oldEmail,content);
            return await handleMessageFromMiddleware(message);
        }

        public async Task<User> RegisterUser(User newUser)
        {
            HttpContent content = new StringContent(JsonSerializer.Serialize(newUser), Encoding.UTF8, "application/json");
            HttpResponseMessage message = await client.PutAsync("https://localhost:8443/users", content);
            return await handleMessageFromMiddleware(message);
        }

        public async Task<User> ValidateUser(string email, string password)
        {
            HttpContent content = new StringContent(JsonSerializer.Serialize(password), Encoding.UTF8, "application/json");
            HttpResponseMessage message = await client.PostAsync("https://localhost:8443/users/?email=" + email, content);
            return await handleMessageFromMiddleware(message);
        }

        private async Task<User> handleMessageFromMiddleware(HttpResponseMessage message)
        {
            string jsonObj = await message.Content.ReadAsStringAsync();
            if (jsonObj.Contains("check") || jsonObj.Contains("contact server") || jsonObj.Contains("already exists"))
            {
                throw new Exception(jsonObj);
            }
            else
            {
                User result = JsonSerializer.Deserialize<User>(jsonObj);
                return result;
            }
        }
    }
}
