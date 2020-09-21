# StackOverFlowApi

apis
https://api.stackexchange.com/


BASE_URL = "https://api.stackexchange.com/2.2/"


"/questions/{questionIds}?order=desc&sort=activity&site=stackoverflow -> getQuestionsById


"/users?order=desc&sort=reputation&site=stackoverflow" ->get users


/users/{userId}/questions?order=desc&sort=votes&site=stackoverflow ->get questionByUser


/users/{userId}/favorites?order=desc&sort=votes&site=stackoverflow ->getFavoritesByUser

/users/{userId}/answers?order=desc&sort=votes&site=stackoverflow" ->getAnswersByUser

