/* eslint-disable @typescript-eslint/no-unused-vars */
import { INext, IReq, IRes } from './../../common/interfaces'

export default (req: IReq, res: IRes, next: INext) => {
	return res.status(200).json({
		message: 'App is working'
	})
}
