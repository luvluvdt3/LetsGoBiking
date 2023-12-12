namespace RoutingServer.Model
{
    public class ResultNearestCity
    {
        public ErrorResult ErrorResult { get; }

        public string CityName { get; }

        public ResultNearestCity(ErrorResult errorResult)
        {
            this.ErrorResult = errorResult;
        }

        public ResultNearestCity(string cityName) 
        {
            this.CityName = cityName;
        }

        public bool HasErrorResult()
        {
            return ErrorResult != null;
        }
    }
}
