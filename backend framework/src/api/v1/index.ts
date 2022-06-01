import { Router } from 'express'
import testRoute from './testRoute'

export default function () {
	const apiRouter: Router = Router()
	apiRouter.use('/test', testRoute)
	return apiRouter
}
